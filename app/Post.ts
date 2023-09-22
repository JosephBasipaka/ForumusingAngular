export interface post{
    id : number,
    content : string,
    likes : number,
    author : { id : number, name : string}
}