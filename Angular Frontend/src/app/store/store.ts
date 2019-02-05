import * as actions from './constants/constants';

export interface IAppState {
    todos: ITodo[];
    lastUpdate: Date;
    test:string;
}

export interface ITodo {
    id: number;
    description: string;
    responsible: string;
    priority: string;
    isCompleded: boolean;
}

export const INITAL_STATE: IAppState = {
    todos: [],
    lastUpdate: null,
    test:''
}

export function rootReducer(state, action) {
    switch (action.type) {
        case actions.ADD_TODO:
            action.todo.id = state.todos.length + 1;
            return Object.assign({}, state, {
                todos: state.todos.concat(Object.assign({}, action.todo)),
                lastUpdate: new Date(),
            });

        case actions.REMOVE_ALL_TODOS:
        console.log('triggered')
        console.log(state)
        console.log('-------')
        console.log(action)
            return Object.assign({}, state, {
                todos: [],
                lastUpdate: new Date(),
                test:"hsssssssaha"
            })
    }
    return state;
}