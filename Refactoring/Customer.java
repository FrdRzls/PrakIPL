private boolean ValidateRequest(CustomerInquiryRequest request, int customerIDFieldLength, int productFieldLength) {
    if (request.CustomerProduct.ProductNumber != null && request.Customer.CustomerID != null) {
        if (!string.IsNullOrEmpty(request.CustomerProduct.ProductNumber) && !string.IsNullOrEmpty(request.Customer.CustomerID)) {
            // Both were populated
            throw new BusinessException(HandledErrors.InvalidBothParameterMessage);
        } else if (string.IsNullOrEmpty(request.Customer.CustomerID) && string.IsNullOrEmpty(request.CustomerProduct.ProductNumber)) {
            // If objects were instantiated but not populated
            throw new BusinessException(HandledErrors.CustomerEmptyMessage);
        } else if (!string.IsNullOrEmpty(request.Customer.CustomerID)) {
            // Note: ProductNumber was equal to string.empty
            // Check Customer ID length
            if (request.Customer.CustomerID.Length > customerIDFieldLength) {
                throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage);
            }
        } else {
            // Note: CustomerID was equal to string.empty
            // Check Product Length
            if (request.CustomerProduct.ProductNumber.Length > productFieldLength) {
                throw new BusinessException(HandledErrors.ProductInvalidLengthMessage);
            }
        }
    } else if (request.CustomerProduct.ProductNumber == null && request.Customer.CustomerID == null) {
        // Both were null
        throw new BusinessException(HandledErrors.CustomerEmptyMessage);
    } else if (request.CustomerProduct.ProductNumber == null) {
        // ProductNumber was null, and CustomerID was not null
        if (request.Customer.CustomerID.Length > customerIDFieldLength) {
            throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage);
        }
    } else { // ProductNumber not null, and CustomerID was null
        // Check Product Length
        if (request.CustomerProduct.ProductNumber.Length > productFieldLength) {
            throw new BusinessException(HandledErrors.ProductInvalidLengthMessage);
        }
    }

    // Set objects below with formatted data i.e., PadLeft
    if (request.Customer.CustomerID != null) {
        request.Customer.CustomerID = request.Customer.CustomerID.PadLeft(customerIDFieldLength, '0');
    }

    if (request.CustomerProduct.ProductNumber != null) {
        request.CustomerProduct.ProductNumber = request.CustomerProduct.ProductNumber.PadLeft(productFieldLength, '0');
    }

    return true;
}
