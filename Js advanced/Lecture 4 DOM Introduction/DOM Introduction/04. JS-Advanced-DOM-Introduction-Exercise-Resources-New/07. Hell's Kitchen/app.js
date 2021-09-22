function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      //get input
      let textAreaElement = document.querySelector('#inputs textarea');
      let input = textAreaElement.value;

      input = JSON.parse(input);
      //filter
      let restourants = {};
      for (const line of input) {
         //get restourant and workers
         let [restourantName, workers] = line.split(' - ');
         workers = workers.split(', ').map(e => {
            let [name, salary] = e.split(' ');
            return { name, salary: Number(salary) };
         })

         if (!restourants.hasOwnProperty(restourantName)) {
            restourants[restourantName] = {
               restourantName,
               workers: [],
               getAvrSalary() {
                  return this.workers.reduce((acc, x) => acc += x.salary, 0) / this.workers.length;
               }
            }
         }
         restourants[restourantName].workers = restourants[restourantName].workers.concat(workers);
      }

      let restourantsArr = Object.values(restourants);
      restourantsArr.sort((a, b) => b.getAvrSalary() - a.getAvrSalary());
      let sortedWorkers = restourantsArr[0].workers.sort((a, b) => b.salary - a.salary);
      let outRestourantString = `Name: ${restourantsArr[0].restourantName} Average Salary: ${restourantsArr[0].getAvrSalary().toFixed(2)} Best Salary: ${sortedWorkers[0].salary.toFixed(2)}`;

      let outWorkersString = [];
      for (const worker of sortedWorkers) {
         outWorkersString.push(`Name: ${worker.name} With Salary: ${worker.salary}`);
      }

      //output
      document.querySelector('#bestRestaurant p').textContent = outRestourantString;
      document.querySelector('#workers p').textContent = outWorkersString.join(' ');
   }
}