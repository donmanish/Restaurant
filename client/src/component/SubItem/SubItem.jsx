/* eslint-disable no-redeclare */
/* eslint-disable react/prop-types */
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemText from "@mui/material/ListItemText";
import ListItemAvatar from "@mui/material/ListItemAvatar";
import Checkbox from "@mui/material/Checkbox";
import Avatar from "@mui/material/Avatar";
import { useEffect } from "react";

function SubItem({ item, checkedItems, setCheckedItems, onToggle }) {
  const itemList = item.subItems;

  // Function to check if item is in checkedItems
  function handleChecked(value) {
    return (
      checkedItems.filter((checkedItem) => checkedItem.id === value.id).length >
      0
    );
  }

  // Function to toggle the checkbox and update localStorage
  function onToggle(value) {
    const updatedCheckedItems = handleChecked(value)
      ? checkedItems.filter((checkedItem) => checkedItem.id !== value.id)
      : [...checkedItems, value];

    // Update checkedItems state
    setCheckedItems(updatedCheckedItems);

    // Update localStorage
    localStorage.setItem("checkedItems", JSON.stringify(updatedCheckedItems));
  }

  // Load checked items from localStorage when component mounts
  useEffect(() => {
    const storedCheckedItems =
      JSON.parse(localStorage.getItem("checkedItems")) || [];
    setCheckedItems(storedCheckedItems);
  }, []);

  return (
    <List
      dense
      sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }}
    >
      {itemList.map((value) => {
        const labelId = `checkbox-list-secondary-label-${value.id}`;

        return (
          <ListItem
            key={value.id}
            secondaryAction={
              <Checkbox
                edge="end"
                onChange={() => onToggle(value)} // Toggle the item
                color="success"
                checked={handleChecked(value)} // Determine if checked
                inputProps={{ "aria-labelledby": labelId }}
              />
            }
          >
            <ListItemButton>
              <ListItemAvatar>
                <Avatar
                  alt={`Avatar n°${value.id}`}
                  src={`/static/images/avatar/${value.image}`}
                />
              </ListItemAvatar>
              <ListItemText
                id={labelId}
                primary={`Name: ${value.name}, Price: ${value.price}rs`}
              />
            </ListItemButton>
          </ListItem>
        );
      })}
    </List>
  );
}

export default SubItem;
