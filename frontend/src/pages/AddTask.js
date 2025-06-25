import { useState } from 'react';
import { createTask, updateTask } from '../services/TaskService';
import './AddTask.css'; 

const defaultTask = {
  title: '',
  description: '',
  status: '',
  priority: '',
  dueDate: ''
};

function TaskForm({ taskId }) {
  const [task, setTask] = useState(defaultTask);
  const [notifMessage, setNotifMessage] = useState(null);

  const handleChange = e => {
    const { name, value } = e.target;
    setTask(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (taskId) {
        await updateTask(taskId, task);
        showNotification('Task updated successfully!');
      } else {
        await createTask(task);
        showNotification('Task created successfully!');
        setTask(defaultTask);
      }
    } catch (error) {
      console.error('Error saving task:', error);
      showNotification('Failed to save task.', true);
    }
  };

  const showNotification = (message, isError = false) => {
    setNotifMessage({ message, isError });
    setTimeout(() => setNotifMessage(null), 3000); // Hide after 3 seconds
  };

  return (
    <div className="form-wrapper">
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label><br />
          <input name="title" value={task.title} onChange={handleChange} required />
        </div>
        <div>
          <label>Description:</label><br />
          <textarea name="description" value={task.description} onChange={handleChange} />
        </div>
        <div>
          <label>Status:</label><br />
          <select name="status" value={task.status} onChange={handleChange} required>
            <option value="" disabled hidden>-- Select Status --</option>
            <option value="PENDING">Pending</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="COMPLETED">Completed</option>
          </select>
        </div>
        <div>
          <label>Priority:</label><br />
          <select name="priority" value={task.priority} onChange={handleChange} required>
            <option value="" disabled hidden>-- Select Priority --</option>
            <option value="LOW">Low</option>
            <option value="MEDIUM">Medium</option>
            <option value="HIGH">High</option>
          </select>
        </div>
        <div>
          <label>Due Date:</label><br />
          <input type="date" name="dueDate" value={task.dueDate} onChange={handleChange} required />
        </div>
        <button type="submit">Submit</button>
      </form>

      {/*Added task notification */}
      {notifMessage && (
        <div className={`custom-toast ${notifMessage.isError ? 'error' : ''}`}>
          {notifMessage.message}
        </div>
      )}
    </div>
  );
}

export default TaskForm;
