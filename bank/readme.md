# Bank API



### Show all customers
`GET /api/v1/customers/get`

### Add customer
`POST /api/v1/customers/save` <br />

example of a body:
```json
{
    "username": "CUSTOMER",
    "balance": 6000
}
```

### Update customer
`PUT /api/v1/customers/{id}/update`

<br />

example of a body:
```json
{
    "username": "CUSTOMER_NEW_NAME",
    "balance": 4000
}
```

### Delete customer
`DELETE /api/v1/customers/{id}/delete`


### Deposit money to customer
`PUT /api/v1/customers/{id}/deposit` 
<br />

example of a body:
```json
{
    "balance": 500
}
```


### Withdraw money from customers
`PUT /api/v1/customers/1/withdraw`

<br />

example of a body:
```json
{
    "balance": 1000
}
```


