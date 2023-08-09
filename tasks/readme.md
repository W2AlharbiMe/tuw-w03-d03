


# Tasks API

###  Show all tasks
`GET /api/v1/tasks/get`

### Search for task by title
`GET /api/v1/tasks/search/{title}`

### Save task
`POST /api/v1/tasks/save` <br />

example of a body:

```json
{
  "title": "finish homework",
  "description": "create tasks and bank RESTs",
  "status": false
}
```

### Update task
`PUT /api/v1/tasks/{id}/update` <br />

example of a body:
```JSON
{
  "title": "updated title",
  "description": "updated description",
  "status": true
}
```

### mark task as done or not.
`PUT /api/v1/tasks/{id}/toggle` <br />
**NOTE: this endpoint does not need sending a body.**


### delete task
`/api/v1/tasks/{id}/delete`



