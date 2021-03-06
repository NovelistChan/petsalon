import React,{Component} from 'react';
import display from '../../assets/bone.png';
import {List,Avatar,Icon,Button,Table,Form,Input,Modal,Layout} from 'antd';
import styles from '../index.css';
import Link from 'umi/link';
import {connect} from 'dva';

const FormItem = Form.Item;
const mapStateToProps = (state) =>{
  return {
    list: state.petlist
  }
}

const mapDispatchToProps = (dispatch) =>{
  return {
    // click: ()=>dispatch({type:"typecount/click",payload:{photo:"clothes"}}),
    fetch: ()=>dispatch({type:"petlist/fetchData"}),
    deleteData: ({payload})=>dispatch({type:"petlist/deleteData", payload:payload})
  }
}

@connect(mapStateToProps,mapDispatchToProps)
class myList extends Component{
  state={
    visible:false
  }
  showModel=()=>{
    this.setState({visible:true});
  }
  handleOk = (e) => {
    const { dispatch, form: { validateFields } } = this.props;

    validateFields((err, values) => {
    if (!err) {
      dispatch({
        type: 'petlist/newData',
        payload: values,
      });
      // 重置 `visible` 属性为 false 以关闭对话框
      this.setState({ visible: false });
    }
  });
  }
  handleCancel = (e) => {
    console.log(e);
    this.setState({
      visible: false,
    });
  }
  componentDidMount(){
    this.props.fetch();
  }
  render(){
    const { getFieldDecorator } = this.props.form;
    const data = this.props.list.data===undefined?[]:this.props.list.data;//incase data is not passed from backend
    return (
    <div className={styles.list}>
    <Layout itemLayout="vertical">
      <Button type="dashed" onClick={this.showModel}>
        Add...
        </Button>
    </Layout>
    <Modal
    title="新建记录"
    visible={this.state.visible}
    onOk={this.handleOk}
    onCancel={this.handleCancel}>
    <Form>
        <Form.Item label="名字">
          {getFieldDecorator('name', {
            rules: [{ required: true }],
          })(
            <Input />
          )}
        </Form.Item>
        <Form.Item label="种类">
          {getFieldDecorator('type', {
            rules: [{ required: true }],
          })(
            <Input />
          )}
        </Form.Item>
        <Form.Item label="编号">
          {getFieldDecorator('id', {
            rules: [{ required: true }],
          })(
            <Input />
          )}
        </Form.Item>
      </Form>
    </Modal>
      <List
        itemLayout="horizontal"
        dataSource={data}
        renderItem={item => (
          <List.Item actions={[<a href="http://www.baidu.com">Service List</a>,
          <Button type="primary" ghost onClick = {
            ()=>{
              console.log(item);
              this.props.deleteData({payload:item});
            }
          }>Delete</Button>,
          <a href="http://www.baidu.com">Edit</a>,
          <Link to="/">Back to index</Link>]}>
            <List.Item.Meta
              avatar={<Avatar src={display} />}
              title={"宠物名字：" + item.name}
              description={"种类：" + item.type}
            />
            </List.Item>
        )}
      />
    </div>
    )
  }
}
export default connect(mapStateToProps)(Form.create()(myList));
