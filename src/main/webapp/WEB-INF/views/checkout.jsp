<div class="container">
    <div class="row">
        <br>
        <div class="col-md-12">
            <!--REVIEW ORDER-->
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h4>Review Order</h4>
                </div>
                <div class="panel-body">
                    <div class="col-md-12">
                        <strong>Subtotal </strong>
                        <div class="pull-right"><span>$</span><span>${userDto.cartTotal}</span></div>
                    </div>
                    <div class="col-md-12">
                        <strong>Your Discount</strong>
                        <div class="pull-right"><span>$</span><span>${discount}</span></div>
                    </div>
                    <div class="col-md-12">
                        <small>Shipping</small>
                        <div class="pull-right"><span>${sessionScope.get("shippingRate")}</span></div>
                        <hr>
                    </div>
                    <sf:form modelAttribute="order" action="${pageContext.request.contextPath}/cart/confirm" method="post">
                        <div class="col-md-12">
                            <strong>Order Total</strong>
                            <div class="pull-right">
                                <span>$</span><span>${total}</span>
                            </div>
                            <hr>
                        </div>

                        <div class="form-group">
                            <label for="address"> Shipping address</label>
                            <sf:textarea class="form-control" id="address" path="address"
                                      placeholder="Enter Your Address"></sf:textarea>
                            <sf:errors path="address" cssClass="help-block" element="em"/>

                        </div>

                        <div class="form-group">
                            <label for="receiverName"> Receiver name</label>
                            <sf:textarea class="form-control" id="receiverName" path="receiverName"
                                      placeholder="Enter Receiver name"></sf:textarea>
                            <sf:errors path="receiverName" cssClass="help-block" element="em"/>
                        </div>

                        <button type="submit" class="btn btn-primary btn-lg btn-block">Checkout</button>
                    </sf:form>
                </div>


            </div>
            <!--REVIEW ORDER END-->
        </div>
    </div>
</div>