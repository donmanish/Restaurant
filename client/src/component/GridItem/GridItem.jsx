import Grid from "@mui/material/Grid2";
import Item from "../Item/Item";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import { useEffect, useState } from "react";


// eslint-disable-next-line react/prop-types
function GridItem({ name, menuItem, savedSubItem }) {
  const [items, setItems] = useState(menuItem);
  const [checkedItems, setCheckedItems] = useState(savedSubItem);

  function getAllItemsFromMenu(name) {
    const getItemList = menuItem
      // eslint-disable-next-line react/prop-types
      .filter((curr) => curr.restaurant.name === name)
      .map((curr) => curr.item);

    setItems(getItemList[0] || []);
  }

  function handleToggle(value) {
    const currentIndex = checkedItems.indexOf(value);
    const newChecked = [...checkedItems];

    if (currentIndex === -1) {
      newChecked.push(value);
    } else {
      newChecked.splice(currentIndex, 1);
    }
    setCheckedItems(newChecked);
  }

  useEffect(() => {
    getAllItemsFromMenu(name);
  }, [name, menuItem]);

  useEffect(() => {
    if (checkedItems.length > 0) {
      localStorage.setItem("SubItem", JSON.stringify(checkedItems)); // Save to localStorage
    } else {
      localStorage.removeItem("SubItem");
    }
    // console.log(checkedItems);
  }, [checkedItems]);

  return (
    <div className="gridItem">
      <h1 className="restaurant-name">Welcome our restaurant, {name}</h1>
      <Box sx={{ flexGrow: 2 }} className="itemgridcontainer">
        <Grid
          container
          spacing={2}
          rowSpacing={1}
          columnSpacing={{ xs: 1, sm: 2, md: 3 }}
        >
          {items.length > 0 ? (
            items.map((curr) => (
              <Grid key={curr.id} size={3}>
                <Item
                  item={curr}
                  checkedItems={checkedItems}
                  setCheckedItems={setCheckedItems}
                  onToggle={handleToggle}
                />
              </Grid>
            ))
          ) : (
            <Typography gutterBottom variant="h3" component="div">
              No food item, please select a restaurant
            </Typography>
          )}
        </Grid>
     
      </Box>
    </div>
  );
}

export default GridItem;
