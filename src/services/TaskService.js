import axios from 'axios';

const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

// Get all tasks
export const getTasks = () => {
  return axios.get(`${API_BASE_URL}/tasks`);
};

// Create a new task
export const createTask = (task) => {
  return axios.post(`${API_BASE_URL}/add`, task);
};

// Update an existing task
export const updateTask = (id, updatedTask) => {
  return axios.put(`${API_BASE_URL}/update/${id}`, updatedTask);
};

// Delete a task by ID
export const deleteTask = (id) => {
  return axios.delete(`${API_BASE_URL}/delete/${id}`);
};
