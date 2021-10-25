## React Testing Library
Enzyme gives React developers utilities to test internals of React components, React Testing Library takes a step back and questions us "how to test React components to get full confidence in our React components": **Rather than testing a component's implementation details, React Testing Library puts the developer in the shoes of an end user of an React application.**

1. React Testing Library is not an alternative to Jest . **Jest** is a test runner.
2. It comes default in create-react-app. If you are not using create-react-app, then you need to install it
   `npm install --save-dev @testing-library/react`

React Testing Library is an alternative to Enzyme. While Enzyme lets us test the implementation details of React components, React Testing Library helps us test the behavior of our React components from the perspective of the users that will use our app.

### Writing our First Test
Before we begin our testing, we need to have a React component that we can test. Lets create a simple React component.

```javascript
import React from 'react';

function App() {
  return (
    <div>
      <h1>Hello World</h1>
    </div>
  );
}
export default App;
```

We will write our tests in a separate file, named App.test.js.

Notice the **.test.js in the file name. Jest will **automatically detect** any files with the name ending with test.js.

So lets write our first test. In our first test, we will test whether the h1 element in our App component is rendered in the DOM or not.

```javascript
import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('render h1 element', () => {
  render(<App />);
  expect(screen.getByText('Hello World')).toBeInTheDocument();
});
```

Lets understand the code of our first test.
At the top, we have import statements. First we import React, then we **import two main things** from React Testing Library:

1. A **render** function that will be used to render the component which we will be testing
2. A **screen** object that contains different methods to select elements in the document.
   We also import the App component which we want to test.

After that, we are calling the /test/ function which is a function provided by Jest. It takes **two arguments**:
1. A string that represents the **name of the test**
2. A function which contains the code of our test

Inside this function, passed as a second argument to /test/ function, we first render our App component using the /render/ function from React Testing Library. The render function takes any JSX that you want to render.

The /screen/ object contains different query methods which the React Testing Library provides. In our first test we used the /getByText/ query method to select the /h1/ element using the text it contains. Using an assertion provided by Jest, we test if the h1 element is rendered in the DOM.

To run our first test, use one of the following commands:
```bash
npm test
npm run test
```

If you didn’t use create-react-app to create a React project, you will need to have a test script in the package.json file before you run the test command.

When you run the test command, you will see the output in the terminal that will indicate whether our test has **passed or failed**.

To see the HTML output of your component, you could use a method named debug of the screen object.

Lets make a slight modification in our first test
```javascript
test('render h1 element', () => {
  render(<App />);

  screen.debug();

  expect(screen.getByText('Hello World')).toBeInTheDocument();
});
```

If you run Jest in watch mode, it will automatically run the tests when you make any change in your tests. With /create-react-app/, you don’t need to run the /test/ command again and again.
After making the above change, check the output in the terminal. Our test will pass.
Before we write more tests, lets first explore some features of the React Testing Library that can be used to write our tests.

### Selecting Elements
In our first test, we used the /getByText/ method which is one of the query methods provided by React Testing Library. After we have selected an element, we can do different assertions or simulate user interactions to interact with those elements.

The /getByText/ method takes a string that is used to find the element. One caveat of passing a string as an argument to /getByText/ method is that string needs to be an exact match, meaning in our first test, if we had written

`getByText('Hello');`

instead of

`getByText('Hello World');`

our test would have failed because the getByText method would have failed to find the h1 element. When the getByText method fails to find an element, it throws an error.

You could also pass a regular expression to getByText for a partial match. So in our first test, we could write
`getByText(/Hello/);`
to select the h1 element.

React Testing Library provides different query methods for selecting elements. Each of those query methods belong to one of the following categories:
1. getBy\**
2. getByAll\**
3. queryBy\**
4. queryAllBy\**
5. findBy\**
6. findAllBy\**

/getByText/ that we used in our first test belongs to the first category of queries, i.e. /getBy/**.

There are other methods that can be used to select elements. Following methods belong to the getBy** category of queries.
1. getByText
2. getByRole
3. getByLabelText
4. getByPlaceholderText
5. getByAltText
6. getByDisplayValue

There are similar methods available in other categories as well, for example, the following methods can be found under the queryBy** category.
1. queryByText
2. queryByRole
3. queryByLabelText
4. queryByPlaceholderText
5. queryByAltText
6. queryByDisplayValue

Surely you see a pattern here. Other categories have similar methods.
To learn all about the individual methods, check the official docs and API reference, for example for getByText.

### Selecting Elements using the id Attribute
If none of the above mentioned query methods allows you to select any particular element, you could add a **/data-testid/** attribute on the element that you want to select and then select that element using /getByTestId/ function.
Example:

```<span data-testid="mySpan">Hello</span>```
span element above can be selected as shown below:
```const el = getByTestId('mySpan');```


### The Differences Between Different Query Methods
Let’s take a look at the differences between the query methods belonging to getBy** category. Generally, the same methods belonging to different categories also work the in same way - the only difference will be that of the category.

We will take a look at the differences between different categories later.

**/getByText:/** Selects an element that contains the text passed as an argument to this method

/**getByRole:**/ Selects an element by the accessibility role

/**getByLabelText:**/ Selects an element associated with the label whose htmlFor attribute matches the string passed to this method as an argument.

/**getByPlaceholderText:**/ Selects the element by its placeholder text.

/**getByAltText:**/ Selects an element (normally an img element) with the matching value of alt attribute.

/**getByDisplayValue:**/ Returns the input, textarea, or select element that has the matching display value.

### The Differences Between Different Query Categories
Now lets take a look at the differences between different query categories:

/**getBy:**/ Query methods in this category return the first matching element or throw an error if no match was found or if more than one match was found.

/**getByAll:**/ Query methods in this category return an array of all matching elements or throw an error if no elements matched

**/queryBy:/** Query methods in this category return the first matching element or return null if no elements match. They also throw an error if more than one match is found.

/**queryAllBy:**/ Query methods in this category return an array of all matching elements or return an empty array if no elements match

/**findBy:**/ Query methods in this category return a promise which resolves when an element is found which matches the given query. The promise is rejected if no element is found or if more than one element is found after a default timeout of 1000ms

/**findAllBy:**/ Query methods in this category return a promise which resolves to an array of elements when any elements are found which match the given query. The promise is rejected if no elements are found after a default timeout of 1000ms

### When To Use Which Query Variant
Just in case its not clear from the above description, if you want to select an element that is rendered after an asynchronous operation, use the findBy** or findByAll** variants.

If you want to assert that some element should not be in the DOM, use queryBy** or queryByAll** variants. Otherwise use getBy** and getByAll** variants.

### Assertive Functions
In our first test written above, we used a method named toBeInTheDocument to check if the h1 element was in the DOM or not. This is an assertive function that is used on the right side of an assertion.

```javascript
test('render h1 element', () => {
  render(<App />);

  screen.debug();

  expect(screen.getByText('Hello World')).toBeInTheDocument();
});
```

Jest provides many assertive function but React Testing Library adds more assertive functions in an extra package named jest-dom.

This package comes pre-installed in a project created with create-react-app.
Assertive functions provided by this package are:
toBeDisabled
toBeEnabled
toBeEmpty
toBeEmptyDOMElement
toBeInTheDocument
toBeInvalid
toBeRequired
toBeValid
toBeVisible
toContainElement
toContainHTML
toHaveAttribute
toHaveClass
toHaveFocus
toHaveFormValues
toHaveStyle
toHaveTextContent
toHaveValue
toHaveDisplayValue
toBeChecked
toBePartiallyChecked
toHaveDescription

After the above theory, lets write some more tests.

###Testing Multiple Elements
We saw above that there are query categories that allow us to select multiple elements.
Lets write a test to check if there is a specific number of list items in an ul element.
Before we write the test, we need to change out App component

```javascript
function App() {
  return (
    <div>
      <ul className="animals">
        <li>Cat</li>
        <li>Whale</li>
        <li>Lion</li>
        <li>elephant</li>
        <li>Rhino</li>
      </ul>
    </div>
  );
}
```

Now our component renders a list of animals and we will write a test to assert the following:
1. The ul element should be in the document.
2. The ul element should have a class named animals.
   3.There should be exactly 5 list items in the ul element.
```javascript
import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('list contains 5 animals', () => {
  render(<App />);

  const listElement = screen.getByRole('list');
  const listItems = screen.getAllByRole('listitem');

  expect(listElement).toBeInTheDocument();
  expect(listElement).toHaveClass('animals');
  expect(listItems.length).toEqual(5);
});
```

In the above test we are using the **getByRole** and **getAllByRole** queries to select the /ul/ element and /li/ element respectively. Then we are making the three assertions that were mentioned before the test.

Notice the assertive functions used in the assertions in the above test:

**toBeInTheDocument** and **toHaveClass** are from /jest-dom/, whereas /toEqual/ is from Jest itself.

###Asynchronous Tests
Now lets write a test that will test whether a certain component is rendered after an asynchronous request to /jsonplaceholder/ api to fetch a single user.

Before we write the test, lets change our App component and also create a User component that will be rendered once the user has been fetched from the API.

**User Component**
```javascript
function User(props) {
  const { name, email } = props.user;

  return (
    <div className="person">
      <h3>{name}</h3>
      <span>{email}</span>
    </div>
  );
}
```

**App Component**
```javascript
function App() {
  const [user, setUser] = React.useState(null);
  const [error, setError] = React.useState('');

  React.useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/users/1')
      .then((response) => response.json())
      .then((user) => setUser(user))
      .catch((error) => setError(error.message));
  }, []);

  if (error) {
    return <span>{error}</span>;
  }

  return <div>{user ? <User user={user} /> : <span>Loading...</span>}</div>;
}
```

The App component makes a request to the API to fetch a user. Once the user has been fetched, it is saved in the state. If there’s an error, it is also saved in the state and the error message is rendered instead of the User component.

To test whether the user is fetched from the API and rendered in the DOM, we will mock the fetch function so that we don’t make an actual request while testing.

“Mocking” is a good technique for avoiding actual Http requests. With your unit tests, you typically don’t want to send real requests, since you care about your code, not whether your browser works correctly.

You can learn more about mocking and related concepts in this standalone JavaScript testing tutorial.
To mock the fetch function, we will provide our own implementation of the fetch function.

```javascript
window.fetch = jest.fn(() => {
  const user = { name: 'Jack', email: 'jack@email.com' };

  return Promise.resolve({
    json: () => Promise.resolve(user),
  });
});
```
This replaces the original /fetch/ method with a custom method which will return a promise but which will not send an actual Http request.

For more details on how to mock function or modules in Jest, you can refer to their official
documentation which covers mocking in detail.

When we render the App component, our component will now use the mocked version of the fetch function.

Now lets write some tests. Instead of writing one test, we will write three tests to assert the following:
1. While the request is in progress, a loading text should be visible.
2. Therafter, the user’s name should be rendered in the document.
3. In case of an error, an error message should be rendered.

Lets write our tests one by one.
The first test will be related to the loading text.
```javascript
import {
  render,
  screen,
  waitForElementToBeRemoved,
} from '@testing-library/react';

test('loading text is shown while API request is in progress', async () => {
  render(<App />);
  const loading = screen.getByText('Loading...');

  expect(loading).toBeInTheDocument();

  await waitForElementToBeRemoved(() => screen.getByText('Loading...'));
});
```

A couple of things that should be noted in the above test:
1. We’re using an /async/ function
2. We’re using the /waitForElementToBeRemoved/ function

When testing components that contain an asynchronous operation, like an API request in our App component, you might see a warning message which says
Warning: An update to App inside a test was not wrapped in act(…)

This warning means that something happened to our component when we weren’t expecting anything to happen. For details on this warning, the following blog post by the creator of React Testing Library might be interesting: Fix the “not wrapped in act(…)” warning.

In our case, we get this warning because after we assert that the loading text should be in the document, our component’s state is updated and the component is re-rendered. Our promise (in the fake fetch method) does resolve instantly after all.

We can avoid this warning by waiting for the component to re-render, after the API request, before ending our test. To wait for a component to re-render, we have used the waitForElementToBeRemoved function. This function will not let our test finish until the loading text has disappeared from the DOM, which only happens in case of an error or a successful API request.

The waitForElementToBeRemoved function returns a Promise so we need to await it. And in order to use the await keyword, we have used an async function.

Now lets write the second test to assert that user is successfully fetched and the user’s name is rendered in the DOM.

```javascript
test("user's name is rendered", async () => {
  render(<App />);
  const userName = await screen.findByText('Jack');
  expect(userName).toBeInTheDocument();
});
```

Since our mocked version of fetch function returns a Promise that resolves with the following user object
const user = { name: 'Jack', email: 'jack@email.com' };

in our test, we assert that an element with the text “Jack” should be rendered in the DOM.
Also notice the use of findByText: We are using this query method because query methods in the findBy** category should be used to select elements that are rendered in the DOM after an asynchronous operation.

We can’t use queryBy** or getBy** variants here. We also need to await the result of screen.findByText("Jack"), so we used an async function.

Now lets write our final asynchronous test which will assert that in case of an error, our App component shows an error message.

```javascript
test('error message is shown', async () => {
  window.fetch.mockImplementationOnce(() => {
    return Promise.reject({ message: 'API is down' });
  });

  render(<App />);

  const errorMessage = await screen.findByText('API is down');
  expect(errorMessage).toBeInTheDocument();
});
```

The only thing to be noticed here is that we are using a different version of our mocked fetch function. This is needed because our initial mocked version of the fetch function doesn’t reject the Promise.

So to force our API request to fail, we reject the Promise with an object containing a message property.

The value of this message property is saved in the state of our App component and displayed to the user when our API request fails. Hence we’re checking for this message with findByText("API is down").

### Grouping Tests in a Test Suite
We wrote three tests to test our App component that contains asynchronous code. When we run our tests, there is no indication on the terminal that these three tests are related to each other.

We can group them together in a test suite by wrapping them with the describe function provided by Jest.

The following is the final code of our three tests grouped together in a test suite.
```javascript
import React from 'react';
import {
  render,
  screen,
  waitForElementToBeRemoved,
} from '@testing-library/react';
import App from './App';

window.fetch = jest.fn(() => {
  const user = { name: 'Jack', email: 'jack@email.com' };

  return Promise.resolve({
    json: () => Promise.resolve(user),
  });
});

describe('Testing App Component', () => {
  test('loading text is shown while API request is in progress', async () => {
    render(<App />);
    const loading = screen.getByText('Loading...');
    expect(loading).toBeInTheDocument();
    await waitForElementToBeRemoved(() => screen.getByText('Loading...'));
  });

  test("user's name is rendered", async () => {
    render(<App />);
    const userName = await screen.findByText('Jack');
    expect(userName).toBeInTheDocument();
  });

  test('error message is shown', async () => {
    window.fetch.mockImplementationOnce(() => {
      return Promise.reject({ message: 'API is down' });
    });

    render(<App />);

    const errorMessage = await screen.findByText('API is down');
    expect(errorMessage).toBeInTheDocument();
  });
});
```

Now if you run the tests or if jest is running in watch mode, you will see the following output in the terminal.

Notice how our tests are grouped together under Testing App Component.

### Simulating User Interactions
React Test Library provides an fireEvent API which can be used to trigger events like change on an input element.

React Testing Library also provides another API for simulating use interactions in a separate package named user-event. This API builds on top of the fireEvent API and contains functions which mimic browser behavior more closely than the fireEvent API.

For example, fireEvent.change() triggers only a change event whereas UserEvent.type triggers change, keyDown, keyPress and keyUp events.

In the following tests, we will use the user-event library instead of the fireEvent API for simulating user interactions with HTML elements.

For this, let’s change our App component once again to render a counter that can be incremented using the “increment” and “decrement” buttons.

```javascript
function App() {
  const [counter, setCounter] = React.useState(0);

  const increment = () => {
    setCounter((prevCounter) => ++prevCounter);
  };

  const decrement = () => {
    setCounter((prevCounter) => --prevCounter);
  };

  return (
    <div>
      <h2 data-testid="counter">{counter}</h2>
      <button onClick={decrement}>Decrement</button>
      <button onClick={increment}>Increment</button>
    </div>
  );
}
```

We will write two tests to assert that counter is incremented and decremented correctly. We will also group both our tests in a single test suite.

Note the data-testid attribute on the h2 element. As mentioned before, this attribute can be used to select elements using the getByTestId query method. In the following two tests, we will use this method to select the h2 element.

```javascript
import React from 'react';
import { render, screen } from '@testing-library/react';
import UserEvent from '@testing-library/user-event';
import App from './App';

describe('Testing App Component', () => {
  test('counter is incremented on increment button click', () => {
    render(<App />);

    const counter = screen.getByTestId('counter');
    const incrementBtn = screen.getByText('Increment');

    UserEvent.click(incrementBtn);
    UserEvent.click(incrementBtn);

    expect(counter.textContent).toEqual('2');
  });

  test('counter is decremented on decrement button click', () => {
    render(<App />);

    const counter = screen.getByTestId('counter');
    const decrementBtn = screen.getByText('Decrement');

    UserEvent.click(decrementBtn);
    UserEvent.click(decrementBtn);

    expect(counter.textContent).toEqual('-2');
  });
});
```

The first test checks if the counter is incremented correctly by simulating a click event on the increment button twice. As the initial value of counter is zero, after clicking the increment button twice, our counter’s value should be 2.

That is what we are checking in our assertion.
Note that we have passed a string "2" to the toEqual function instead of a number 2. The reason is that we are using the textContent property of an HTML element to get the value of the counter.

Since the textContent property always yields a string, we could either convert the return value of counter.textContent to a number and then assert that it should be equal to 2 or we could just use a string "2".

In the second test, we are testing the decrement functionality by clicking the decrement button twice and asserting that counter’s value should be “-2”.

You might have expected that, as we decrement the counter after incrementing it twice in the first test, the counter’s value should be “0” instead of “-2” but that’s not the case!

That’s because the React Testing Library automatically unmounts the React component tree after each test.

It should be noted that this automatic cleanup is done only when we use the React Testing Library with a testing framework that has an afterEach global function. As Jest has such a function, our component tree is automatically cleaned up after each test. That is why counter’s value is “-2” after the second test.

### Testing Callbacks
Consider a scenario where you have a component that represents an input element. This component receives two props:
The value of the input element
And a callback function which will be used to handle the onChange event on the input element

In addition, this input element is a controlled, meaning its value is derived from the state of the component in which it is rendered.
Now you want to test whether the value of the input element is updated correctly and also make sure that the callback function is called each time the value of the input changes.

We will write a couple of tests for this case but before we do that, lets create an Input component and also render this Input component in the App component, passing in the required props from the App component to the Input component.

Input component
```javascript
export function Input(props) {
  const { handleChange, inputValue } = props;
  return <input onChange={handleChange} value={inputValue} />;
}
```
App component
```javascript
function App() {
  const [inputValue, setInputValue] = React.useState('');

  const handleChange = (event) => {
    setInputValue(event.target.value);
  };

  return (
    <div>
      <Input handleChange={handleChange} inputValue={inputValue} />
    </div>
  );
}
```

Now lets write our tests.
In the first test, we will assert that the input value is updated correctly.

```javascript
import UserEvent from '@testing-library/user-event';

test('input value is updated correctly', () => {
  render(<App />);

  const input = screen.getByRole('textbox');
  UserEvent.type(input, 'React');

  expect(input.value).toBe('React');
});
```

We are selecting the input element by its role. What’s great about the getByRole query method is that if you pass any role to this method that is not associated with any element in your component, it will suggest you the available roles once you run the test.

After selecting the input element, we are using the user-event API to trigger an onChange event on the input element. Since we wrote "React" in the input component, we expect its value to be "React".

For our second test, we will test whether or not the handleChange callback function is called every time input value is changed.

To test this, we will mock the handleChange function which is passed to the Input component so that we can track how many times it was called. And instead of rendering the App component, we will render the Input component, passing in the mocked version of the handleChange function.

```javascript
import UserEvent from '@testing-library/user-event';
import { Input } from './App';

test('call the callback every time input value is changed', () => {
  const handleChange = jest.fn();

  render(<Input handleChange={handleChange} inputValue="" />);

  const input = screen.getByRole('textbox');
  UserEvent.type(input, 'React');

  expect(handleChange).toHaveBeenCalledTimes(5);
});
```

As we will render the Input component instead of App, we need to import the Input component in our test file. At the start of our test, we have mocked the handleChange function and then passed it as a prop to the Input component.

We again are using the user-event API to trigger an onChange event on the input element and after that we are asserting that the handleChange function has been called 5 times because we typed "React" (= 5 characters) in the input element.