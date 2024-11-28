import Login from './Components/Login/login'
import React, { useEffect, useState } from 'react';
import { Router, Route, Switch, Routes } from 'react-router-dom';
import Student from './Components/StudentListing/StudentListingComp'
import axios from 'axios';

function App() {
  

  return (

    

    <div>


      <Routes>
        <Route path="/" element={<Login/>}/>
        <Route path="/Student" element={<Student/>}/>
      </Routes>
    </div>
   

  );
}

export default App;
