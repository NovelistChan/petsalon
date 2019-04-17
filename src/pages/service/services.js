import react,{Component} from 'react';
import display from '../../assets/paw.png';
import {List,Avatar} from 'antd';
import styles from '../index.css';
import Link from 'umi/link';
import {connect} from 'dva';
const mapStateToProps = (state) =>{
  return {
    list: state.servicelist
  }
}

const mapDispatchToProps = (dispatch) =>{
  return {
    fetch: ()=>dispatch({type:"servicelist/fetchData"})
  }
}

@connect(mapStateToProps,mapDispatchToProps)
class myList extends Component{
  componentDidMount(){
    this.props.fetch();
  }
  render(){
    const data = this.props.list.data===undefined?[]:this.props.list.data;//incase data is not passed from backend
    return (
    <div className={styles.list}>
      <List
        itemLayout="horizontal"
        dataSource={data}
        renderItem={item => (
          <List.Item actions={[<a href="http://www.baidu.com">baidu</a>,<Link to="/">Back to index</Link>]}>
            <List.Item.Meta
              avatar={<Avatar src={display} />}
              title={<a href="https://ant.design">{"服务名称：" + item.serviceCategory}</a>}
              description={"服务费用：" + item.fee}
            />
            </List.Item>
        )}
      />
    </div>
    )
  }
}

export default myList;
