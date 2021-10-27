## React Redux
Redux is a predictable state container for JavaScript apps.

Let's consider you want to withdraw money from bank. You will have in your mind an action to withdraw money. Banks have a vault which stores cash. You cannot directly go to vault and withdraw money. Instead, you will go to cashier, who will take your action request and then go to vault bring the cash and give it you. After this, vault amount will be updated.

**Redux Store** is like a bank's vault. It holds state of the application.
**Action** the only way to change the state is to dispatch an action, an object describing what happened. Consider below example. Here type represents action and amount represents payload.
```json
{
  "type": "WITHDRAW_MONEY",
  "payload": {
    "amount": 1000
  }
}
```
**Reducer** Cashier is to bank what the /reducer/ is to Redux. If you want to update state of your application, you convey your /action/ to the /reducer/ like you would go to cashier. After reducers takes action, state is updated. Reducer return the updated state.

Let's consider following example where a bank starts with 1000 in its vault.
```javascript
function reducer(state = 1000, action) {
  switch(action.type) {
    case "WITHDRAW_MONEY":
      return state.amount - action.payload.amount;
      break;
    case "DEPOSITE_MONEY":
      return state.amount + action.payload.amount;
    break;
    default:
      return state;
  }
}
```