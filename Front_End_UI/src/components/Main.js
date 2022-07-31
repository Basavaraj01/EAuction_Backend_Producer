import React from 'react'
import axios from 'axios';
import Select from 'react-select'
import BuyerTableDetails from './BuyerTableDetails';
import ProdTableDetails from './ProdTableDetails'
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';

class Main extends React.Component {
    constructor() {
        super()
        this.state = {
            count: false,
            users: [],
            selectOptions: [],
            id: "",
            name: '',
            loaddata: '',
            filltable: {},
            fillbuyer: []
        }
    }
    async getOptions() {
        const res = await axios.get('http://localhost:8081/e-auction/api/v1/seller/products')
        const data = res.data
        console.log('the response is', data)
        this.setState({ loaddata: data })
        const options = data.map(d => ({
            "value": d.productId,
            "label": d.productId
        }))
        this.setState({ selectOptions: options })
    }

    callme = () => {
        this.setState({ count: true })
        this.setState({
            filltable: this.state.loaddata.filter(f => (f.productId === this.state.id))[0]
        }, () => {
            console.log(this.state.filltable);
        });
    }

    handleChange(e) {
        this.setState({ id: e.value, name: e.label })
        console.log("the selected option is", this.state.loaddata.filter(f => (f.productId === this.state.id))[0])
    }

    getBuyers = (e) => {
        e.preventDefault();
        let id = this.state.id
        axios.get(`http://localhost:8081/e-auction/api/v1/seller/show-bids/${id}`)
            .then(res => {
                const persons = res.data;
                this.setState({
                    fillbuyer: persons
                }, () => {
                    console.log('the response of buyer is', this.state.fillbuyer);
                });
            })
    }

    componentDidMount() {
        this.getOptions()
    }

    render() {
        return (
            <div>
                <div class="row">
                    <div class="col-md-6 offset-md-3">
                        <br /><br />
                        <h3>Welcome to EAuction</h3><br />
                        <p>please select the product Id and click on Get </p>
                        <ButtonGroup aria-label="Basic example">
                            <Select options={this.state.selectOptions} onChange={this.handleChange.bind(this)} ><option value="">Select your option</option></Select>
                            &nbsp;&nbsp;<Button variant="success" onClick={this.callme}>
                                Get
                            </Button>
                        </ButtonGroup>
                        {this.state.count ? <ProdTableDetails name={this.state.filltable} /> : ''}<br />
                        {Object.keys(this.state.filltable).length !== 0 ? <Button variant="primary" onClick={this.getBuyers}>
                            Bids
                        </Button> : ''}                        
                    </div>
                </div><br />
                {console.log('nnnnnnn', this.state.fillbuyer)}
                {this.state.fillbuyer.length !== 0 ? <BuyerTableDetails name={this.state.fillbuyer} /> : null}
            </div >
        )
    }
}

export default Main;