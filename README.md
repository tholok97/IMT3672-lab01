# Lab01 in IMT3672

## Task description (copied from gitlab)

Create an application consisting of 3 activities. 

### The first, entry activity (A1), should have

* editable text field (T1)
* slider (S1)
* a drop-down list of options (L1)
* a button (B1)

### The second activity (A2) should have:

* non-editable text field (T2)
* another non-editable text field (T3)
* a button (B2)

### The third activity (A3) should have:

* a single editable text field (T4)
* a single button (B3)

### Tasks

* When user presses B1, activity A2 becomes active.
* When user presses B2, activity A3 becomes active.
* When user presses B3, activity A2 becomes active again.
* When user presses Back button from A2, she will go to A1.
* When user presses Back button from A1, it will quit the app.
* When user presses Back button from A3, it goes back to A2.
* The field T2 shows "Hello " + the value of T1 from A1
* The field T3 shows "From A3: " + the value of T4 from A3
* The selection of the drop-down list L1 from A1 should be persistent between different runs of the application, such that, when the user changes the selection, upon the consecutive execution of the app, the selection is as the user picked it, not as the app had it initially as default when the app was executed for the first time.

### Hints

* use Intent to pass data between activities
* use startActivityForResult() between A2 and A3
