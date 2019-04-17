import styles from './index.css';
import { Layout, Menu, Breadcrumb } from 'antd';
import { Button, Icon } from 'antd';
import { Link } from 'umi';

const ButtonGroup = Button.Group;
const { Header, Content, Footer } = Layout;

function BasicLayout(props) {
  return (
    <Layout className="layout">
      <Header>
        <div className="logo" />
        <Menu
          theme="dark"
          mode="horizontal"
          defaultSelectedKeys={['2']}
          style={{ lineHeight: '64px' }}
        >
          <Menu.Item key="1"><Link to="/owner/owners">Owner</Link></Menu.Item>
          <Menu.Item key="2"><Link to="/pet/pets">Pet</Link></Menu.Item>
          <Menu.Item key="3"><Link to="/service/services">Service</Link></Menu.Item>
        </Menu>
      </Header>
      <Content style={{ padding: '0 50px' }}>

        <div style={{ background: '#fff', padding: 24, minHeight: 600 }}>{props.children}</div>

      </Content>
      <Footer style={{ textAlign: 'center' }}>
        Petsalon v1.0.0
      </Footer>
    </Layout>
  );
}


export default BasicLayout;
