export default{
    namespace:'petlist',
    state:{},
    reducers:{
        setData(state,{payload}){
            return { data: payload};
        },
        appendData(state,{payload}){
            let newData = state.data;
            newData = newData.concat(payload);
            return { data: newData};
        }
    },
    effects:{
        *fetchData({payload},{call,put}){
            const response = yield call(request,'/api/pets');
            yield put({type:'setData',payload:response})
        },
        *newData({payload},{call,put}){
            const value = {
              id: Number(payload.id),
              name: payload.name,
              type: payload.type,
              services:[]
            }
            const response = yield call(request,'/api/pets', {
            headers: {
              'content-type': 'application/json',
            },
            method: 'POST',
            body: JSON.stringify(value),
          });
            yield put({type:'appendData',payload:response})
        },
        *deleteData({payload},{call,put}){
            console.log(payload);
            const id = payload.id;
            const value = {
              id: payload.id,
              name: payload.name,
              pets:[]
            }
            yield call(request,'/api/pets/' + id, {
              headers: {
                'content-type': 'application/json',
              },
              method: 'DELETE',
              body: JSON.stringify(value),
          });
            const response = yield call(request,'/api/pets');
            yield put({type:'setData',payload:response})
        }
    }
}

function checkStatus(response) {
    if (response.status >= 200 && response.status < 300) {
      return response;
    }

    const error = new Error(response.statusText);
    error.response = response;
    throw error;
  }
async function request(url, options) {
  const response = await fetch(url, options);
  checkStatus(response);
//  debugger
  return await response.json();
}
