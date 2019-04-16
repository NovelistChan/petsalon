import styles from './index.css';
import {Button,Tag,Row,Col,Avatar} from 'antd';
import React,{Component} from 'react';
import {connect} from 'dva';
import pic from '../assets/cat.jpg';
import Link from 'umi/link';

class MyPage extends Component{
  render(){
    return(
    <div className={styles.normal}>
      <Avatar src={pic}/>
      <Col>
        <Row>
          Welcome!
          </Row>
        <Row>
          Click the Buttons left above to enter Petsalon!
        </Row>
      </Col>
    </div>)
  }
}

export default MyPage;
