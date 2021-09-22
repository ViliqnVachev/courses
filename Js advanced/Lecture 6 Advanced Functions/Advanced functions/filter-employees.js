function solve(params, filter) {
    params = JSON.parse(params);
    if (filter != 'all') {
        let [prop, value] = filter.split('-');
        params = params.filter(e => e[prop] == value);
    }
    for (let index = 0; index < params.length; index++) {
        console.log(`${index}. ${params[index]["first_name"]} ${params[index]["last_name"]} - ${params[index]["email"]}`);
    }
}

solve(`[{
    "id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`,
    'all'
)