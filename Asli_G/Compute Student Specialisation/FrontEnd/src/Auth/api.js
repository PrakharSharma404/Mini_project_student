import axios from "axios";

// Create an Axios instance
const api = axios.create({
  baseURL: "http://localhost:9191", // Replace with your backend base URL
  headers: {
    "Content-Type": "application/json",
  },
});

// Add a request interceptor to attach the token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    // Get the token from localStorage
    if (token) {
      
      config.headers.Authorization = `Bearer ${token}`; // Attach token as Bearer
      console.log("Printing from frontend",config.headers.Authorization);
      
    }
    
    return config;
  },
  (error) => {
    // Handle request errors
    return Promise.reject(error);
  }
);

export default api;
