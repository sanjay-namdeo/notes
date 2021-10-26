## Angular Life Cycle Hooks

1. **ngOnChanges()** This hook/method is called before *ngOnInit* and whenever one or more input properties of the component changes.
This method/hook receives a SimpleChanges object which contains the previous and current values of the property.

2. **ngOnInit()** This hook gets called once, after the *ngOnChanges* hook.
It initializes the component and sets the input properties of the component.

3. **ngDoCheck()** It gets called after *ngOnChanges* and *ngOnInit* and is used to detect and act on changes that cannot be detected by Angular.

> We can implement our change detection algorithm in this hook. *ngAfterContentInit( )* It gets called after the first *ngDoCheck* hook. This hook responds after the content gets projected inside the component.

4. **ngAfterContentChecked()** It gets called after *ngAfterContentInit* and every subsequent *ngDoCheck*. It responds after the projected content is checked.

5. **ngAfterViewInit()** It responds after a component's view, or a child component's view is initialized.

6. **ngAfterViewChecked()** It gets called after *ngAfterViewInit*, and it responds after the component's view, or the child component's view is checked.

7. **ngOnDestroy()** It gets called just before Angular destroys the component. This hook can be used to clean up the code and detach event handlers.
