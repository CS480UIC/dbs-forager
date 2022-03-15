import React from "react";
import TextField from "@material-ui/core/TextField";
import AddIcon from "@material-ui/icons/Add";
import RemoveIcon from "@mui/icons-material/Remove";
import IconButton from "@material-ui/core/IconButton";
import Button from "@material-ui/core/Button";
import "./Donor.css";

function Donor() {
  const [quantity, setQuantity] = React.useState(1);
  const addClicked = () => {
    setQuantity(quantity + 1);
  };
  const removeClicked = () => {
    if (quantity > 1) {
      setQuantity(quantity - 1);
    }
  };
  return (
    <div className="container">
      <h1>Donate</h1>
      <TextField
        id="standard-basic"
        required
        label="Food item"
        variant="standard"
      />
      <div className="quantity">
        <div className="qty-label">Quantity</div>
        <IconButton
          aria-label="add"
          color="primary"
          className="icon-button"
          size="small"
          onClick={addClicked}
        >
          <AddIcon />
        </IconButton>
        <div classname="qty-value">{quantity}</div>
        <IconButton
          aria-label="delete"
          color="primary"
          className="icon-button"
          size="small"
          onClick={removeClicked}
        >
          <RemoveIcon />
        </IconButton>
      </div>
      <div className="add-button">
        <Button variant="contained">Add</Button>
      </div>
    </div>
  );
}

export default Donor;
