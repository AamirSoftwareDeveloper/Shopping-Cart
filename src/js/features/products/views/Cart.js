import React from 'react'
import { Link } from "react-router-dom"
import Loader from '../../../Components/Fragments/Loader'
import ProductsStores from "../state/ProductsStores"
import ProductsAction from "../actions/ProductsActions"

class Cart extends React.Component {

  constructor(props){
    super(props)
    if(ProductsStores.products.length == null || ProductsStores.products.length <1){
      const { history } = this.props
      history.push('/')
      window.location.reload()
    }
  }
  render(){
    return(
      <div className="container-fluid" id="bodyContent">
        <div className="row">
          <div className="col-lg-12">
            <Loader showOrHide={!ProductsStores.isLoading} />
                <div className="card">
                  <h5 className="card-header">Check Out
                    <Link to="/">
                      <button className="btn btn-custom float-right">Shop More</button>
                    </Link>
                  </h5>
                    <ul className="list-group list-group-flush">
                    {
                      ProductsStores.products.map(function(product){
                        if(product.addedToCart){
                          return(
                              <li className="list-group-item" key={product.productKey}>
                                  <div className="card-body">
                                    <h5 className="card-title">{product.productName}</h5>
                                    <p className="card-text">Quantity : {product.quantity}</p>
                                    <a className="btn btn-default">{product.quantity*product.productPrice}</a>
                                  </div>
                              </li>
                          )
                        }
                      })
                    }
                    </ul>
                </div>
                <br/>
          </div>
            <div className="col-lg-8">
              <strong className="float-right">Total Amount : ₹{ProductsStores.cartTotalAmount}</strong>
            </div>
            <div className="col-lg-4">
              <button className="btn btn-custom float-right" onClick={ProductsAction.placeOrder}>Place Order</button>
            </div>
        </div>
      </div>
    )
  }
}

export default Cart
