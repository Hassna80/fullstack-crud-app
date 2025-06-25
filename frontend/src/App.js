import { BrowserRouter as Router, Routes, Route, Link, Navigate } from 'react-router-dom';
import TaskListTable from './pages/TaskListTable';
import TaskForm from './pages/AddTask';
import EditTask from './pages/EditTask';

import './App.css';

function App() {
  return (
    <Router>
      <nav>
        <Link to="/tasks"></Link> 
        <Link to="/tasks/add"></Link>
        <Link to="/edit/:id"></Link>
      </nav>
      <div className="container">
        <Routes>
          <Route path="/" element={<Navigate to="/tasks" replace />} />
          <Route path="/tasks" element={<TaskListTable />} />
          <Route path="/tasks/add" element={<TaskForm />} />
          <Route path="/edit/:id" element={<EditTask />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;