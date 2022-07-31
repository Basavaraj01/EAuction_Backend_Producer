import React from 'react'
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';

class NavigationBar extends React.Component {
  render() {
    return (
      <>
        <Navbar bg="dark">
          <Container>
            <Navbar.Brand href="#home">
              <img
                src="/eauctionlogo.png"
                width="80"
                height="30"
                className="d-inline-block align-top"
                alt="React Bootstrap logo"
              />
            </Navbar.Brand>
          </Container>
        </Navbar>
      </>
    )
  }
}

export default NavigationBar