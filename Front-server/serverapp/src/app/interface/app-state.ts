import { DataState } from "../enum/Data-state.enum";

export interface AppState<T> {

    dataState : DataState;
    appData? : T;
    error? : String;
}