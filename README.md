## Java Application Deployment on Amazon EKS with GitHub Actions
This guide provides instructions for deploying a Java application on Amazon EKS (Elastic Kubernetes Service) using GitHub Actions. The deployment process consists of two jobs within GitHub Actions: one for building and pushing a Docker image to Amazon ECR (Elastic Container Registry), and another for deploying the application to an Amazon EKS cluster.

#### Prerequisites
Before you proceed, ensure you have the following prerequisites in the secrets in the github secrets:
- AWS_REGION=your-aws-region **(same arn that is used for assigment-iac repo)**
- AWS_ROLE_ARN=aws-role-arn **(same arn that is used for assigment-iac repo)**
- EKS_CLUSTER_NAME=eks-clustername **(obtained from output of terraform assignment-iac)**
- ECR_REPO_NAME=ecr-repo-name **(obtained from output of terraform assignment-iac)**

Chage the repository value in `demo-charts/demo/values.yaml`
- Copy the ecr_repo_urls= 123456789.dkr.ecr.`**`.amazonaws.com/assignment-demo-assignment-svc **(obtainer from output of terraform assignment-iac)**
- Replace ** from ecr_repo_url with your AWS_REGION look like this **123456789.dkr.ecr.`eu-west1`.amazonaws.com/assignment-demo-assignment-svc**
- change the value in `demo-charts/demo/values.yaml` for repository variable and it will looks like this
  ```yaml
  image:
     repository: 123456.dkr.ecr.eu-west-1.amazonaws.com/assignment-demo-assignment-svc
     pullPolicy: Always
     tag: "latest"
  ```

#### Usage
- Push to the `main` branch or create a pull request to trigger this workflow.
- Docker image is tagged with the format `${BRANCH_NAME}-${COMMIT_ID}`.
- The deployment workflow is triggered automatically upon successful completion of the Build and Push Docker Image workflow.
- The helm chart deployment manifest (`demo-charts/demo`) is updated with the latest Docker image tag.
