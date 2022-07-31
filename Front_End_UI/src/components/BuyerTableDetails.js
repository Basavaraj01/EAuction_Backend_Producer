import Table from 'react-bootstrap/Table';

function BuyerTableDetails(props) {
    return (
        <Table striped bordered hover size="sm">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Bid Amount</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                </tr>
            </thead>
            {props.name ? props.name.map((buyer, i) => <tbody>
                <tr>
                    <td>{++i}</td>
                    <td>{buyer.bidAmount}</td>
                    <td>{buyer.firstName}</td>
                    <td>{buyer.email}</td>
                    <td>{buyer.phone}</td>
                </tr>
            </tbody>) : null}
        </Table>
    );
}
export default BuyerTableDetails;