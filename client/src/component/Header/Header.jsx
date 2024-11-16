import { AppBar, Toolbar } from "@mui/material";
import { Link } from "react-router-dom";

const AppBarComponent = () => {
  return (
    <AppBar position="static" className="headerContainer">
      <Toolbar disableGutters>
        <ul className="navlinks">
          <li>
            <Link to={"/"}>Home</Link>
          </li>
          <li>
            {" "}
            <Link to={"/menu"}>Menu</Link>
          </li>
        </ul>
      </Toolbar>
    </AppBar>
  );
};

export default AppBarComponent;
