function solve() {
   let buttons = Array.from(document.querySelectorAll('.add-product'));
   let checkoutButton = document.querySelector('.checkout');
   let textArea = document.querySelector('textarea');
   //You bought {list} for {totalPrice}.
   buttons.forEach(button => button.addEventListener('click', addProduct));
   let obj = {};
   checkoutButton.addEventListener('click', checkout);
   function checkout(event) {
      let totalPrice = Object.values(obj).reduce((acc, x) => acc + x, 0);
      let list = Object.keys(obj).join(', ');
      let result = `You bought ${list} for ${totalPrice.toFixed(2)}`;
      textArea.value += result;
      buttons.forEach(button => button.disabled = true);
   }

   function addProduct(event) {
      let productName = event.target.parentElement.previousElementSibling.querySelector('.product-title').textContent;
      let price = event.target.parentElement.nextElementSibling.textContent;
      if (!obj.hasOwnProperty(productName)) {
         obj[productName] = 0;
      }
      obj[productName] += Number(price);
      //Added {name} for {money} to the cart.\n

      textArea.value += `Added ${productName} for ${price} to the cart.\n`
      console.log();
   }
}