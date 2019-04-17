export default{
    namespace:'servicelist',
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
            const response = yield call(request,'/api/services');
            yield put({type:'setData',payload:response})
        },
        *newData({payload},{call,put}){
            const value = {
              id: Number(payload.id),
              serviceCategory: payload.serviceCategory,
              fee: payload.fee,
            }
            const values = value;
            const response = yield call(request,'/api/services', {
            headers: {
              'content-type': 'application/json',
            },
            method: 'POST',
            body: JSON.stringify(value),
          });
            yield put({type:'appendData',payload:response})
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
  debugger
  return await response.json();
}
