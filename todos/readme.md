


# Todo API

###  Show all tasks
`GET /api/v1/tasks/get`

### Search for todo by title
`GET /api/v1/tasks/search/{title}`

### Save todo
`POST /api/v1/tasks/save` <br />

example of a body:

```json
{
  "title": "finish homework",
  "description": "create tasks and bank RESTs",
  "status": false
}
```

### Update todo
`PUT /api/v1/tasks/{id}/update` <br />

example of a body:
```JSON
{
  "title": "updated title",
  "description": "updated description",
  "status": true
}
```

### mark todo as done or not.
`PUT /api/v1/todos/{id}/toggle` <br />
**NOTE: this endpoint does not need sending a body.**


### delete todo
`/api/v1/todos/{id}/delete`



