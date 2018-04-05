<sf:form class="form-horizontal" modelAttribute="configuration" method="post"
         action="${pageContext.request.contextPath}/manage/configuration">
    <fieldset>

        <!-- Form Name -->
        <legend>Updating Configuration Info</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="shippingRate">Shipping rate</label>
            <div class="col-md-4">
                <sf:input id="shippingRate" path="shippingRate" type="number" min="0" placeholder=""
                          class="form-control input-md"/>
                <sf:errors path="shippingRate" cssClass="help-block" element="em"/>

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="freeCup">Free cup</label>
            <div class="col-md-4">
                <sf:input id="freeCup" path="freeCup" type="number" placeholder="" min="0"
                          class="form-control input-md"/>
                <sf:errors path="freeCup" cssClass="help-block" element="em"/>

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="totalForFreeShipping">Total for Free Shipping</label>
            <div class="col-md-4">
                <sf:input id="totalForFreeShipping" path="totalForFreeShipping" min="0" type="number" placeholder=""
                          class="form-control input-md"/>
                <sf:errors path="totalForFreeShipping" cssClass="help-block" element="em"/>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="button"></label>
            <div class="col-md-4">
                <button type="submit" id="button" class="btn btn-primary">Submit</button>
            </div>
        </div>

    </fieldset>
</sf:form>