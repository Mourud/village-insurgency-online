
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
const firebaseConfig = {
  // Use environment variables to hide sensitive information
  apiKey: "AIzaSyCBbVjGrHMebj0Myiv_MWJ9qQyyOjUVE6E",
  authDomain: "village-insurgency.firebaseapp.com",
  databaseURL: "https://village-insurgency-default-rtdb.firebaseio.com",
  projectId: "village-insurgency",
  storageBucket: "village-insurgency.appspot.com",
  messagingSenderId: "696309742003",
  appId: "1:696309742003:web:228ceed0572c2aaf50f3c6",
  measurementId: "G-M7FEKDQZ0S"
};

// Initialize Firebase
export const app = initializeApp(firebaseConfig);
