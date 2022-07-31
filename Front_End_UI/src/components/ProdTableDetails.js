import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row'

function ProdTableDetails(props) {
  return (
    <>
      <br /><br />
      <Row>
        <Form.Label column lg={2}>
          Product Name
        </Form.Label>
        <Col sm="8">
          <Form.Control type="text" placeholder="Normal text" value={props.name.productName} />
        </Col>
      </Row>
      <br />
      <Row>
        <Form.Label column lg={2}>
          Short Description
        </Form.Label>
        <Col sm="8">
          <Form.Control type="text" placeholder="Normal text" value={props.name.shortDescription} />
        </Col>
      </Row>
      <br />
      <Row>
        <Form.Label column lg={2}>
          Detailed Description
        </Form.Label>
        <Col sm="8">
          <Form.Control type="text" placeholder="Normal text" value={props.name.detailedDescription} />
        </Col>
      </Row>
      <br />
      <Row>
        <Form.Label column lg={2}>
          Category
        </Form.Label>
        <Col sm="8">
          <Form.Control type="text" placeholder="Normal text" value={props.name.category} />
        </Col>
      </Row>
      <br />
      <Row>
        <Form.Label column lg={2}>
          Starting Price
        </Form.Label>
        <Col sm="8">
          <Form.Control type="text" placeholder="Normal text" value={props.name.startingPrice} />
        </Col>
      </Row>
      <br />
      <Row>
        <Form.Label column lg={2}>
          Bid End Date
        </Form.Label>
        <Col sm="8">
          <Form.Control type="text" placeholder="Normal text" value={props.name.bidEndDate.substring(1, 10)} />
        </Col>
      </Row>
    </>
  )
}

export default ProdTableDetails