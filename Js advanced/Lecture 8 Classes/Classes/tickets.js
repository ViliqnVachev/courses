function solve(tickets, criteria) {
    class Tickets {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }
    let result = [];
    for (const ticketString of tickets) {
        let [destination, price, status] = ticketString.split('|');
        price = Number(price);
        let ticket = new Tickets(destination, price, status);
        result.push(ticket);
    }
    result.sort((a, b) => {
        if (criteria === 'price') {
            return a[criteria] - b[criteria];
        } else {
            return a[criteria].localeCompare(b[criteria]);
        }
    });

    return result;

}

console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'destination'
));