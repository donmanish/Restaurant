import Grid from "../../component/GridItem";
import { ListofItem } from "../../api/menu";
import { useEffect, useState } from "react";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

function Menu() {
  const navigate = useNavigate();
  const [menuItem, setMenuItem] = useState([]);
  const [restaurantNameList, setRestaurantNameList] = useState([]);
  const savedSubItem = JSON.parse(localStorage.getItem("SubItem")) || [];
  const restName = localStorage.getItem("RestaurantName");

  const [name, setName] = useState(savedSubItem.length > 0 ? restName : "");

  async function getAllMenuItems() {
    const response = await ListofItem();
    const menuItemList = await response.menu;
    const restaurantList = getTheName(menuItemList);

    setRestaurantNameList(restaurantList);
    setMenuItem(menuItemList);
  }

  function getTheName(menuItemList) {
    const restaurantList = [];
    menuItemList.map((curr) => {
      const nameList = curr.restaurant.name;
      restaurantList.push(nameList);
    });

    return restaurantList;
  }

  const handleChange = (event) => {
    setName(event.target.value);
    localStorage.setItem("RestaurantName", event.target.value);
  };

  function handleSubmit() {
    navigate("/order");
  }

  useEffect(() => {
    getAllMenuItems();
  }, [name]);

  return (
    <>
      <section className="menuContainer">
        <div className="selectContain">
          <FormControl fullWidth>
            <InputLabel
              id="demo-simple-select-label"
              className="inputSelectfield"
            >
              Name
            </InputLabel>
            <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={name}
              label="Name"
              onChange={handleChange}
              sx={{ width: "75%" }}
            >
              {restaurantNameList.map((curr, index) => (
                <MenuItem key={index} value={curr}>
                  {curr}
                </MenuItem>
              ))}
            </Select>

            <div className="restaurant-contain">
              <Grid
                name={name}
                menuItem={menuItem}
                savedSubItem={savedSubItem}
              />
            </div>
            <div className="rowbutton">
              <Button variant="contained" onClick={handleSubmit}>
                Submit
              </Button>
            </div>
          </FormControl>
        </div>
      </section>
    </>
  );
}

export default Menu;
