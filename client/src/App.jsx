// import { useState } from 'react'
// import reactLogo from "./assets/react.svg";
// import viteLogo from "/vite.svg";
import "./App.css";
import Home from "./pages/Home";
import Menu from "./pages/Menu";
import "./assets/css/style.css";
import ProtectedRoute from "./security/ProtectedRoute";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./component/Layout";
import Order from "./pages/Order";

function App() {
  return (
    <>
      <div className="App">
        <BrowserRouter future={{ v7_startTransition: true }}>
          <Routes>
            <Route
              path="/"
              element={
                <ProtectedRoute>
                  <Layout>
                    <Home />
                  </Layout>
                </ProtectedRoute>
              }
            />
            <Route
              path="/menu"
              element={
                <ProtectedRoute>
                  <Layout>
                    <Menu />
                  </Layout>
                </ProtectedRoute>
              }
            />
            <Route
              path="/order"
              element={
                <ProtectedRoute>
                  <Layout>
                    <Order />
                  </Layout>
                </ProtectedRoute>
              }
            />
          </Routes>
        </BrowserRouter>
      </div>
    </>
  );
}

export default App;
