import { useParams } from 'react-router-dom';
import AddTask from '../pages/AddTask';

function EditTask() {
  const { id } = useParams();  // I got the id from the url

  return (
    <div className="container">
      <AddTask taskId={id} />
    </div>
  );
}

export default EditTask;
