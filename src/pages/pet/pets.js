import react,{Component} from 'react';
import display from '../../assets/pet.png';
import {List,Avatar,Icon} from 'antd';
import styles from '../index.css';
import Link from 'umi/link';
import {connect} from 'dva';
const mapStateToProps = (state) =>{
  return {
    list: state.petlist
  }
}

const mapDispatchToProps = (dispatch) =>{
  return {
    // click: ()=>dispatch({type:"typecount/click",payload:{photo:"clothes"}}),
    fetch: ()=>dispatch({type:"petlist/fetchData"})
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
              title={<a href="https://ant.design">{"宠物名字：" + item.name}</a>}
              description={"种类：" + item.type}
            />
            </List.Item>
        )}
      />
    </div>
    )
  }
}

export default myList;
