# Java Application Deployment on Amazon EKS with GitHub Actions

This guide provides instructions for deploying a Java application on Amazon EKS (Elastic Kubernetes Service) using GitHub Actions. The deployment process consists of two jobs within GitHub Actions: one for building and pushing a Docker image to Amazon ECR (Elastic Container Registry), and another for deploying the application to an Amazon EKS cluster.

## Prerequisites

Before you proceed, ensure you have the following prerequisites:

- [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html) installed on your local machine for local development.
- AWS IAM role with the necessary permissions for Amazon ECR and EKS.
- [GitHub Actions Workflow](.github/workflows/build-and-push.yml) and [Deployment Workflow](.github/workflows/deploy.yml) files in your repository. 

## Build and Push Docker Image Workflow

### Steps

1. **Checkout Code:**
   - Clones the repository and checks out the source code.

2. **Configure AWS Credentials:**
   - Uses the AWS CLI to configure AWS credentials, assuming the IAM role for ECR.

3. **Set up JDK 17:**
   - Configures Java 17 for the build using Maven.

4. **Build with Maven:**
   - Builds the Java application using Maven.

5. **Login to Amazon ECR:**
   - Logs in to the Amazon ECR registry using AWS credentials.

6. **Build and Push Docker Image:**
   - Builds a Docker image, tags it, and pushes it to the specified Amazon ECR repository.

### Usage

- Push to the `main` branch or create a pull request to trigger this workflow.
- Docker image is tagged with the format `${BRANCH_NAME}-${COMMIT_ID}`.

## Deployment Workflow

### Steps

1. **Checkout Code:**
   - Clones the repository and checks out the source code.

2. **Configure AWS Credentials:**
   - Uses the AWS CLI to configure AWS credentials, assuming the IAM role for EKS.


3. **Update Kubeconfig:**
   - Updates the Kubernetes configuration for the specified Amazon EKS cluster.

4. **Set Image Tag:**
   - Modifies the image tag in the `values.yaml` Kubernetes deployment manifest.

5. **Deploy to Cluster:**
   - Install or upgrade helm chart chart

### Usage

- This workflow is triggered automatically upon successful completion of the Build and Push Docker Image workflow.
- The helm chart deployment manifest (`demo-charts/demo`) is updated with the latest Docker image tag.

---

**Note:** Make sure to customize the IAM roles, AWS region, and other parameters in the GitHub Actions workflow files according to your AWS setup. Adjust the Java version and other configurations as needed for your Java application.
