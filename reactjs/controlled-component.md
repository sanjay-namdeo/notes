## Controlled Components
In HTML form elements such as `<input>`, `<textarea>`, and `<select>` typically maintain their own state and update it based on user input. When a user submits a form, the values from the these elements are sent with the form.

With ReactJs it works differently. The component containing form will *keep track of the value of the input in its state and will re-render the component each time callback function* e.g. onChange is fired as the state will be updated. A form element whose value is controlled by React in this way is called a "controlled component".

> With a controlled component, every state mutation will have an associated handler function. This makes it straightforward to modify or validate user input.

Example

```javascript
import React, {useState} from 'react';

export default function App() {
  const [inputValue, setInputValue] = useState("");
  const handleInputChange = (e) => {
    setInput(e.target.value);
  }

  const handleSubmitButton = () => {
    alert(inputValue);
  }

  return (
    <div>
      <input value={inputValue} onChange={handleInputChange} />
      <input type="submit" value="submit" onClick={handleSubmitButton} />
    </div>
  );
}

```