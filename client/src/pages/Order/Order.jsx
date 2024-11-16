import { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

function Order() {
  const [rows, setRows] = useState([]);
  const [order, setOrder] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const savedItems = JSON.parse(localStorage.getItem("SubItem")) || [];
    setRows(savedItems);
  }, []);

  useEffect(() => {
    setOrder(rows.length);
  }, [rows]);

  const totalPrice = rows.reduce(
    (acc, item) => acc + item.price * item.quantity,
    0
  );

  const handleDelete = (id) => {
    const updatedRows = rows.filter((row) => row.id !== id);
    setRows(updatedRows);

    localStorage.setItem("SubItem", JSON.stringify(updatedRows));
    localStorage.setItem("checkedItems", JSON.stringify(updatedRows));
  };

  const [open, setOpen] = useState(false);
  const handleOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    setOpen(false);
  };

  function handlePay() {
    localStorage.removeItem("SubItem");
    localStorage.removeItem("checkedItems");
    navigate("/");
  }

  return (
    <div>
      <h1>Your Order</h1>
      <h4>Total order make : {order}</h4>
      {/* Custom Table */}
      <table style={{ width: "100%", borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th style={styles.tableHeader}>ID</th>
            <th style={styles.tableHeader}>Item Name</th>
            <th style={styles.tableHeader}>Price</th>
            <th style={styles.tableHeader}>Quantity</th>
            <th style={styles.tableHeader}>Description</th>
            <th style={styles.tableHeader}>Image</th>
            <th style={styles.tableHeader}>Action</th>{" "}
            {/* New column for Delete */}
          </tr>
        </thead>
        <tbody>
          {rows.length > 0 ? (
            rows.map((row, index) => (
              <tr key={row.id} style={styles.tableRow}>
                <td style={styles.tableCell}>{index + 1}</td>{" "}
                {/* Display sequential ID */}
                <td style={styles.tableCell}>{row.name}</td>
                <td style={styles.tableCell}>${row.price}</td>
                <td style={styles.tableCell}>{row.quantity}</td>
                <td style={styles.tableCell}>{row.description}</td>
                <td style={styles.tableCell}>
                  <img
                    src={row.image}
                    alt={row.name}
                    style={{ width: 50, height: 50, objectFit: "cover" }}
                  />
                </td>
                <td style={styles.tableCell}>
                  <button
                    onClick={() => handleDelete(row.id)}
                    style={styles.deleteButton}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7" style={styles.tableCell}>
                No items in the order
              </td>
            </tr>
          )}
        </tbody>
      </table>

      {/* Total Price */}
      <div>
        <h2>Total Price</h2>
        <p>Total: {totalPrice} rs</p>
      </div>

      {/* payment */}
      <Button variant="contained" onClick={handleOpen}>
        Proceed to payment
      </Button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="child-modal-title"
        aria-describedby="child-modal-description"
      >
        <Box sx={{ ...modalStyle, width: 200 }}>
          <h2 id="child-modal-title">Total</h2>
          <p id="child-modal-description">{totalPrice} rs</p>
          <Button variant="contained" onClick={handlePay}>
            pay
          </Button>
          <Button variant="contained" onClick={handleClose}>
            Close
          </Button>
        </Box>
      </Modal>
    </div>
  );
}

// Custom styles for the table
const styles = {
  tableHeader: {
    border: "1px solid #ddd",
    padding: "8px",
    textAlign: "left",
    backgroundColor: "#333",
  },
  tableRow: {
    borderBottom: "1px solid #ddd",
  },
  tableCell: {
    border: "1px solid #ddd",
    padding: "8px",
  },
  deleteButton: {
    backgroundColor: "#f44336", // Red color for the button
    color: "white",
    border: "none",
    padding: "6px 12px",
    cursor: "pointer",
    borderRadius: "4px",
    fontSize: "14px",
  },
};

const modalStyle = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "#333",
  border: "2px solid #000",
  boxShadow: 24,
  pt: 2,
  px: 4,
  pb: 3,
};

export default Order;
