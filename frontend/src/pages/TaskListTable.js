import { useEffect, useState } from 'react';
import { getTasks, deleteTask } from '../services/TaskService';
import { Link, useNavigate } from 'react-router-dom';
import './TaskListTable.css';

function TaskListTable() {
  const [tasks, setTasks] = useState([]);
  const [showConfirm, setShowConfirm] = useState(false);
  const [taskToDelete, setTaskToDelete] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    const res = await getTasks();
    setTasks(res.data);
  };

  const confirmDelete = (id) => {
    setTaskToDelete(id);
    setShowConfirm(true);
  };

  const handleDelete = async () => {
    if (taskToDelete) {
      await deleteTask(taskToDelete);
      fetchTasks();
      setTaskToDelete(null);
      setShowConfirm(false);
    }
  };

  return (
    <div className="table-container">
      <h1 className="main-title">My Task Dashboard</h1>
      <div className="table-header">
        <button className="add-btn" onClick={() => navigate('/tasks/add')}>
          + Add New Task
        </button>
      </div>

      <table className="task-table">
        <thead>
          <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th>Priority</th>
            <th>Due Date</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {tasks.length === 0 ? (
            <tr>
              <td colSpan="6" style={{ textAlign: 'center' }}>No tasks found.</td>
            </tr>
          ) : (
            tasks.map((task) => (
              <tr key={task.id}>
                <td>{task.title}</td>
                <td>{task.description}</td>
                <td>{task.status}</td>
                <td>{task.priority}</td>
                <td>{task.dueDate ? new Date(task.dueDate).toLocaleDateString() : '-'}</td>
                <td className="actions">
                  <Link to={`/edit/${task.id}`} className="edit-btn">Edit</Link>
                  <button onClick={() => confirmDelete(task.id)} className="delete-btn">Delete</button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>

      {/* Confirm the delete action*/}
      {showConfirm && (
        <div className="modal-backdrop">
          <div className="modal">
            <p>Are you sure you want to delete this task?</p>
            <div className="modal-buttons">
              <button className="confirm-btn" onClick={handleDelete}>Yes, Delete</button>
              <button className="cancel-btn" onClick={() => setShowConfirm(false)}>Cancel</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default TaskListTable;
