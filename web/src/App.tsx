import React from "react";
import { AppContainer } from "./globalStyle";

import Header from "./components/Header";
import Table from "./components/Table";

import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <React.Fragment>
      <AppContainer />
      <Header />
      <Table />
      <ToastContainer />
    </React.Fragment>
  );
}

export default App;
