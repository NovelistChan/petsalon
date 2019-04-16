import styles from './index.css';
import { Layout, Menu, Breadcrumb } from 'antd';
import { Button, Icon } from 'antd';

const ButtonGroup = Button.Group;
const { Header, Content, Footer } = Layout;

function BasicLayout(props) {
  return (
    <Layout className="layout">
      <Header>
        <ButtonGroup>
        <div className="logo" />
        <a href="http://localhost:8000/owner/owners">
          <Button type="primary">Owners</Button>
        </a>
        <a href="http://localhost:8000/pet/pets">
          <Button type="primary">Pets</Button>
        </a>
        <a href="http://localhost:8000/service/services">
          <Button type="primary">Services</Button>
        </a>
        </ButtonGroup>
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
