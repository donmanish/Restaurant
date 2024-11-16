import PropTypes from "prop-types";

function ProtectedRoute({ children }) {
  return (
    <>
     
      <div className="security-container">
        {children}
      </div>
        
    </>
  );
}

ProtectedRoute.propTypes = {
  children: PropTypes.node.isRequired,
};

export default ProtectedRoute;
