import PropTypes from "prop-types";
import Header from "../Header";
import Footer from "../Footer";
// import Nav from "../component/Nav";
function Layout({ children }) {
  return (
    <>
      <div className="Layout">
          <Header />
        <div className="layoutContainer">
          <main>
            <div className="navBar">
              <div className="content-container">{children}</div>
            </div>
          </main>
        </div>
          <Footer />
      </div>
    </>
  );
}

Layout.propTypes = {
  children: PropTypes.node.isRequired,
};
export default Layout;
