# Plantes vertes API

- [Plantes vertes API](#buber-plants-api)
  - [Create plants](#create-plants)
    - [Create plants Request](#create-plants-request)
    - [Create plants Response](#create-plants-response)
  - [Get plants](#get-plants)
    - [Get plants Request](#get-plants-request)
    - [Get plants Response](#get-plants-response)
  - [Update plants](#update-plants)
    - [Update plants Request](#update-plants-request)
    - [Update plants Response](#update-plants-response)
  - [Delete plants](#delete-plants)
    - [Delete plants Request](#delete-plants-request)
    - [Delete plants Response](#delete-plants-response)

## Create plants

### Create plants Request

```js
POST /plants
```

```json
{
    "name": "Ajouter un nouveau service",
    "description": "Abstraire les données de la classe via un service...",
    "startDateTime": "2022-04-08T08:00:00",
    "endDateTime": "2022-04-08T11:00:00",
}
```

### Create plants Response

```js
201 Created
```

```yml
Location: {{host}}/plants/{{id}}
```

```json
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "Ajouter un nouveau service",
    "description": "Abstraire les données de la classe via un service...",
    "startDateTime": "2022-04-08T08:00:00",
    "endDateTime": "2022-04-08T11:00:00",
    "lastModifiedDateTime": "2022-04-06T12:00:00",
}
```

## Get plants

### Get plants Request

```js
GET /plants/{{id}}
```

### Get plants Response

```js
200 Ok
```

```json
{
    "id": "00000000-0000-0000-0000-000000000000",
    "name": "Ajouter un nouveau service",
    "description": "Abstraire les données de la classe via un service...",
    "startDateTime": "2022-04-08T08:00:00",
    "endDateTime": "2022-04-08T11:00:00",
    "lastModifiedDateTime": "2022-04-06T12:00:00",
}
```

## Update plants

### Update plants Request

```js
PUT /plants/{{id}}
```

```json
{
    "name": "Ajouter un nouveau service",
    "description": "Abstraire les données de la classe via un service...",
    "startDateTime": "2022-04-08T08:00:00",
    "endDateTime": "2022-04-08T11:00:00",
}
```

### Update plants Response

```js
204 No Content
```

or

```js
201 Created
```

```yml
Location: {{host}}/plants/{{id}}
```

## Delete plants

### Delete plants Request

```js
DELETE /plants/{{id}}
```

### Delete plants Response

```js
204 No Content
```