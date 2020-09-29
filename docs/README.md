# User Guide
Duke is a desktop app for managing
tasks, optimized for use via a Command Line
Interface (CLI). 

- Features
- Usage
    - Adding a todo task: `todo`
    - Adding a deadline task: `deadline`
    - Adding an event task: `event`
    - Set task as done: `done`
    - Deleting a task: `delete`
    - Listing all tasks: `list`
    - Find a task: `find`
    - Exit program: `bye`
    
## Features 

### Add new tasks -  `todo` `deadline` `event`
You may add a todo, event or deadline task to the task list.

### Update task progress - `done`
You may mark a task as done.

### Delete task - `delete` 
You may delete a task from the task list.

### Listing a task - `list`
List all existing tasks in the task list.

### Find a task - `find`
Finds a task from the task list that is similar to or matches the keyword provided.

### Save and load task list
Duke will automatically save your task list when you exit and load the task
list when you run the program again.


## Usage
### `todo` `deadline` `event` - Adding tasks
You may add a new todo, event or deadline task to the task list using the following format.

Type of task | Format
------------ | -------------
`todo` | `todo TASK DESCRIPTION`
`deadline` | `deadline TASK DESCRIPTION \by YYYY-MM-DD`
`event` | `event TASK DESCRIPTION \at YYYY-MM-DD`

#### Example
Adding three different type of tasks:
```
todo Clean up my room
deadline Finish math homework \by 2020-12-20
event Attend online course briefing \at 2020-12-20
```
#### Expected Outcome
```
	____________________________________________________________
	 Got it. I've added this task:
		[T][✘] Clean up my room
	 Now you have 6 tasks in the list.
	____________________________________________________________

	____________________________________________________________
	 Got it. I've added this task:
		[D][✘] Finish math homework (by: Dec 20 2020)
	 Now you have 2 tasks in the list.
	____________________________________________________________

	____________________________________________________________
	 Got it. I've added this task:
		[E][✘] Attend online course briefing (at: Dec 20 2020)
	 Now you have 3 tasks in the list.
	____________________________________________________________
```


### `done` - Setting task as done
You may mark a task as done based on the task number.

Format: `done TASK NUMBER`

#### Example
Marking the first task on the list as done:
```
done 1
```
#### Expected Output
```
	____________________________________________________________
	 Nice! I've marked this task as done:
	 [✓] Clean up my room
	____________________________________________________________
```

### `delete` - Deleting task
You may delete a task from your task list based on the task number.

Format: `delete TASK NUMBER`

#### Example
Deleting first task on the list.
```
delete 1
```

#### Expected Output
```
	____________________________________________________________
	 Noted. I've removed this task:
		[T][✘] Clean up my room
	____________________________________________________________
```

### `list` - Listing all tasks
You can list all tasks in the task list using `list`.

Format: `list`

#### Example
```
list
```

#### Expected Output
```
	____________________________________________________________
	 Here are the tasks in your list:
	 1.[T][✓] Clean up my room
	 2.[D][✘] Finish math homework (by: Dec 20 2020)
	 3.[E][✘] Attend online course briefing (at: Dec 20 2020)
	____________________________________________________________
```

### `find` - Find a task
You can look for a task that matches the keyword given.
Keyword input is not case-sensitive.

Format: `find KEYWORD`

#### Example
Find for tasks containing Clean. Keyword: Clean.
```
find clean
```

#### Expected Output
```
	____________________________________________________________
	 Here are the matching tasks in your list:
	 1.[T][✘] Clean up my room
	 2.[T][✘] Clean the curtains
	____________________________________________________________
```

### `bye` - Exiting
Exit the application.

Format: `bye`

#### Example
```
bye 
```
 
#### Expected Output
	____________________________________________________________
	 Bye. Hope to see you again soon!
	____________________________________________________________
	
	

### Command Summary

Action | Format | Example
------------ | ------------- | -------------
Add todo task | `todo TASK DESCRIPTION` | `todo watch TV` 
Add deadline task | `deadline TASK DESCRIPTION \by YYYY-MM-DD` | `deadline Finish math homework \by 2020-12-20`
Add event task | `event TASK DESCRIPTION \at YYYY-MM-DD` | `event Attend online course briefing \at 2020-12-20` 
Set task as done | `done TASK NUMBER` | `done 1`
Delete a task | `delete TASK NUMBER` | `delete 1`
List all tasks | `list` | `list`
Find a task | `find KEYWORD` | `find clean`
Exit Program | `exit` | `exit`