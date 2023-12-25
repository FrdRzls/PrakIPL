private void ValidateRequest(CustomerInquiryRequest request, int customerFieldLength, int productFieldLength)
{
    // 1. Check both parameters are not null and not empty strings
    CheckCustomerInquiryNotNullOrEmpty(request);

    // 2. Check both parameters aren't populated
    CheckCustomerInquiryNullOrEmpty(request);

    // 3. Check CustomerID for field length and pad the parameter
    CheckCustomerIDValid(request, customerFieldLength);

    // 4. Check ProductNumber for field length and pad the parameter
    CheckProductNumberValid(request, productFieldLength);
}

private void CheckCustomerInquiryNotNullOrEmpty(CustomerInquiryRequest request)
{
    // Check both parameters are not null or empty string
    if (!string.IsNullOrEmpty(request.Customer.CustomerID) && !string.IsNullOrEmpty(request.CustomerProduct.ProductNumber))
    {
        // Both were populated
        throw new BusinessException(HandledErrors.InvalidBothParameterMessage);
    }
}

private void CheckCustomerInquiryNullOrEmpty(CustomerInquiryRequest request)
{
    if (string.IsNullOrEmpty(request.Customer.CustomerID) && string.IsNullOrEmpty(request.CustomerProduct.ProductNumber))
    {
        // Both are null or empty string
        throw new BusinessException(HandledErrors.CustomerEmptyMessage);
    }
}

private void CheckCustomerIDValid(CustomerInquiryRequest request, int customerIDFieldLength)
{
    if (!string.IsNullOrEmpty(request.Customer.CustomerID))
    {
        // Check Customer ID length
        if (request.Customer.CustomerID.Length > customerIDFieldLength)
        {
            throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage);
        }

        // Pad the left of the customer id
        request.Customer.CustomerID = request.Customer.CustomerID.PadLeft(
            customerIDFieldLength,
            '0'
        );
    }
}

private void CheckProductNumberValid(CustomerInquiryRequest request, int productFieldLength)
{
    if (!string.IsNullOrEmpty(request.CustomerProduct.ProductNumber))
    {
        // Check Product Length
        if (request.CustomerProduct.ProductNumber.Length > productFieldLength)
        {
            throw new BusinessException(HandledErrors.ProductInvalidLengthMessage);
        }

        // Pad the left of the product number
        request.CustomerProduct.ProductNumber = request.CustomerProduct.ProductNumber.PadLeft(
            productFieldLength,
            '0'
        );
    }
}
