# Nhl System

A service to to deal with nhl api

### Get Schedule by date
**Definition**
`GET /nhl/games?date=2020-01-01`

**Response**

- `200 OK` on success

```json
[
   {
      "gamePk" : "2019020626",
      "status" : {
         "detailedState" : "Final",
         "statusCode" : 7
      },
      "teams" : {
         "away" : {
            "score" : 2,
            "team" : {
               "id" : 18,
               "name" : "Nashville Predators"
            }
         },
         "home" : {
            "score" : 4,
            "team" : {
               "id" : 25,
               "name" : "Dallas Stars"
            }
         }
      }
   }
]
```

**Definition**
`GET /nhl/games?date=01-01-2020`

**Response**

- `500 Internal Server Error`

```json
{
   "timestamp" : "2020-01-02T16:41:02.109+0000",
   "status" : 500,
   "path" : "/nhl/games",
   "error" : "Internal Server Error",
   "message" : "Date does not match pattern"
}
```


